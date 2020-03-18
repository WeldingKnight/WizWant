package com.shopping.MVC_reshop.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChatMessageDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String Chat_init = "select * form chat where userId=?";
	
	
	
}
