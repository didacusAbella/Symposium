package it.blackhat.symposium.helpers;

import javax.servlet.http.HttpServletRequest;

/**
 * This Class extract tag from request
 * @author Symposium Group
 */
public class TagExtractor {

    /**
     * This method extract a tag's List comma separated
     *
     * @param req the request
     * @return the list of tags extracted
     */
    public static String[] extractTag(HttpServletRequest req) {
        return req.getParameter("tags").split(",");
    }
}
