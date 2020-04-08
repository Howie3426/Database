import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VideoPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 4L;

	videoDAO videoDAO;
	ReviewDAO reviewDAO;
	favComedianDAO favComedian;
	comedianDAO comedianDAO;
	
	
    public void init() {
    	videoDAO = new videoDAO(); 
    	reviewDAO = new ReviewDAO();
    	favComedian = new favComedianDAO();
    	comedianDAO = new comedianDAO();
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        	if(request.getParameter("play") != null)
            {
            	loadVideoPlayer(request, response);
            }
            else if(request.getParameter("postReview") != null)
            {
            	postNewReview(request,response);
            }
            else if(request.getParameter("favorite") != null)
            {
            	if( request.getParameter("favorite").contentEquals("addFav"))
            	{
            		addToFavorites(request, response);
            	}
            	else
            	{
            		removeFromFavorites(request, response);
            	}
            }
            else
            {
            	loadVideoPlayer(request, response);
            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
    }
    
    protected void addToFavorites(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException 
    {
    	HttpSession session=request.getSession();  
    	int comedianID = Integer.parseInt(request.getParameter("ID"));
    	String username = (String) session.getAttribute("name");
    	
    	favComedianDAO.createFavorite(username, comedianID);
    	
    	loadVideoPlayer(request, response);
    }
    
    protected void removeFromFavorites(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException 
    {
    	HttpSession session=request.getSession();  
    	int comedianID = Integer.parseInt(request.getParameter("ID"));
    	String username = (String) session.getAttribute("name");
    	
    	favComedianDAO.removefavComedian(username, comedianID);
    	
    	loadVideoPlayer(request, response);
    }
    
    protected void postNewReview(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException 
    {
    	String url = request.getParameter("url");
    	int rating = Integer.parseInt(request.getParameter("rating"));
    	String description = request.getParameter("description");
    	video video = videoDAO.getvideo(url);
    	
    	if(video.getPoster().equalsIgnoreCase(url))
    	{
    		request.setAttribute("reviewError", "Error: You can't review a video you've posted!");
    		loadVideoPlayer(request, response);
    		return;
    	}
    	if(videoDAO.getvideo(url) != null)
    	{
    		request.setAttribute("reviewError", "Error: You've already posted a review!");
    		loadVideoPlayer(request, response);
    		return;
    	}
    	
    	// Let's check if the user posted this video or not, if they did we shouldn't let them leave a review
    	
    	
    	System.out.println("Post new review-->" + "\nURL: " + url + "\nRATING: " + rating + "\nDESCRIPTION: " + description);
    	reviewDAO.getReview(url);
    	
    	loadVideoPlayer(request, response);
    }
    
    protected void loadVideoPlayer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException 
    {
    	HttpSession session=request.getSession();  
    	String url = null;
    	int id;
    	List<Review> listReview = null;
    	video video = null;
    	favComedian favorite = null;
    	comedian comedian = null;
    	
    	if(request.getParameter("ID") != null)
    	{
    		comedian = comedianDAO.getcomedian(Integer.parseInt(request.getParameter("ID")));
    	}
    	else
    	{
        	id = request.getParameter(id)
        	comedian = comedianDAO.getcomedian(id);
    	}
    	

    	url = request.getParameter("url");
    	video = videoDAO.getvideo(url);
    	listReview = reviewDAO.listAllReview(url);
    	comedian = favComedianDAO.getFavorite(favComedian.getfavComedian(id));
    	
    	// They haven't added the comedian as a favorite
    	if(favorite == null)
    	{
    		request.setAttribute("favorite", "addFav");
    	}
    	else
    	{
    		request.setAttribute("favorite", "remFav");
    	}
    	
        request.setAttribute("listReviews", listReview);
    	request.setAttribute("url", url);
    	request.setAttribute("title", video.getTitle());
    	request.setAttribute("description", video.getDescription());
    	request.setAttribute("CID", comedian.getComedianId());
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("watchvideo.jsp");    
        dispatcher.forward(request, response);
    	
    	
    }
    
	
	

}
