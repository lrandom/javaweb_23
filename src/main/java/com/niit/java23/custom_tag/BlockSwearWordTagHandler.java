package com.niit.java23.custom_tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class BlockSwearWordTagHandler extends SimpleTagSupport {
    public String content;

    public void setContent(String content) {
        this.content = content;
        String[] swearWords = {"fuck", "shit", "asshole", "bitch", "damn"};
        for (int i = 0; i < swearWords.length; i++) {
            this.content = this.content.replace(swearWords[i], "***");
        }
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        try {
            out.write("<p>" + this.content + "</p>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (Exception e) {

        }
    }
}
