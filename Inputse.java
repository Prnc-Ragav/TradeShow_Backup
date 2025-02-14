package firstTesting;


public class Inputse {
	public static Inputse inputs = null;
	
	String [][] allInputStrings = {
			{"JohnDoe", "HelloWorld", "JavaRocks", "Valid123", "TextData", "Username", "RandomString", "TestText", "AlphaBeta", "BravoCharlie",
	            "", "   ", "\n", "\t", null, "💩", "超长文本输入", "🔥🔥🔥🔥🔥🔥🔥", "NameWith#Symbol", "Spaces   ",
	            "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; DROP TABLE users; --", "javascript:alert(1)", "../etc/passwd", 
	            "SELECT * FROM users;", "'; EXEC xp_cmdshell('dir'); --", "\"; rm -rf / --", "' OR ''='", "base64_decode('aGFja2Vk')"},
			{"0", "1", "10", "999", "-5", "100", "-100", "2147483647", "-2147483648", "42",
	                "", "abc", "3.14", "one", "NaN", "--100", "123abc", "Infinity", "- 999", "9.99.99",
	                "999999999 OR 1=1", "' UNION SELECT null, username, password FROM users --", "1; DROP TABLE students;", "' OR ''='",
	                "1/0", "'; EXEC xp_cmdshell('shutdown -s'); --", "4294967296", "1E400", "-9999999999999999999", "1000000000*"},
			{"user@example.com", "admin@domain.com", "test123@mail.org", "info@website.net", "hello@company.io", "support@service.dev",
	                    "first.last@edu.edu", "contact@business.biz", "name123@gmail.com", "user+alias@domain.com",
	                    "", "user@", "user@.com", "@domain.com", "user@domain", "user@@domain.com", "user@domain..com", "user@domain,com",
	                    "user@domain com", "user@.domain.com",
	                    "' OR '1'='1' --", "admin' --", "' UNION SELECT email, password FROM users --", "1' OR '1'='1'", "'; DROP TABLE emails;",
	                    "\"; EXEC xp_cmdshell('dir'); --", "' OR '1'='1' /*", "user@example.com<script>alert('XSS');</script>",
	                    "john.doe@evil.com'><script>stealCookies()</script>", "email@domain.com'--"},
			
			{"SecureP@ss1", "Passw0rd!", "Random@123", "Qwerty#987", "Hello@World99", "GoodPass88*", "A1b2C3d4*", "My$tr0ngP@ss",
	                        "Strongest@432", "SafeP@ssword999",
	                        "", "password", "123456", "abcdef", "qwerty", "letmein", "iloveyou", "password123", "admin", "root",
	                        "' OR '1'='1' --", "'; DROP TABLE users;", "admin' --", "' UNION SELECT password FROM users --", "' OR ''='",
	                        "\" OR \"\"=\"", "'; EXEC xp_cmdshell('dir'); --", "password'><script>alert('XSS');</script>", "' OR 1=1#", "' --"},
			
			{
	                    	    // Valid Dates
	                    	    "2025-12-31", "1999-01-01", "2000-02-29", "2024-06-15", "2030-07-20", 
	                    	    "2023-03-10", "2010-05-05", "1980-11-11", "2077-09-09", "2005-04-04",
	                    	    // Invalid Dates
	                    	    "", "31-12-2025", "2024/06/15", "June 15, 2024", "2025-13-01", 
	                    	    "2025-00-12", "2025-02-30", "abcd-ef-gh", "2025-06-40", "0000-00-00",
	                    	    // Vulnerable Dates
	                    	    "' OR '1'='1' --", "'; DROP TABLE dates;", "0000-00-00'; DELETE FROM users; --", 
	                    	    "01-01-1970' OR '1'='1'", "2025-06-15<script>alert('XSS');</script>", 
	                    	    "'; EXEC xp_cmdshell('shutdown -s'); --", "' UNION SELECT birthday, password FROM users --", 
	                    	    "2025-01-01' /*", "2025-06-06' OR 'x'='x'", "2025-06-15'--"
	                    	},
			
			{
	                    	    // Valid URLs
	                    	    "https://example.com", "http://domain.com", "https://www.google.com", 
	                    	    "https://www.facebook.com", "https://blog.website.org", "http://news.site.net", 
	                    	    "https://secure-page.io", "https://user.dashboard.com", "https://app.service.dev", 
	                    	    "http://123.456.789.101",
	                    	    // Invalid URLs
	                    	    "", "htp:/example.com", "https:/example", "ftp://invalid.url", "http:/missing-slash.com", 
	                    	    "https//wrong-format", "www.missinghttp.com", "site.com/no-http", "://invalid.com", 
	                    	    "javascript:alert(1)",
	                    	    // Vulnerable URLs
	                    	    "javascript:alert('XSS')", "data:text/html;base64,PHNjcmlwdD5hbGVydCgnSGFja2VkIScpPC9zY3JpcHQ+", 
	                    	    "http://evil.com/steal?cookie=document.cookie", "'; DROP TABLE urls;", 
	                    	    "https://malicious.com/?param=<script>alert(1)</script>", "https://example.com' OR '1'='1'", 
	                    	    "https://mybank.com?redirect=http://attacker.com", "http://%2525%252E%2525%252E%2525%252E%2525%252E/etc/passwd", 
	                    	    "file:///etc/passwd", "ftp://evil.com"
	                    	},
	                    	
	                    	
			{
	                    	    // Valid Colors
	                    	    "#FF5733", "#000000", "#FFFFFF", "#123ABC", "#00FF00", "#ABCDEF", 
	                    	    "#999999", "#FFA500", "#800080", "#008080",
	                    	    // Invalid Colors
	                    	    "", "red", "#12", "#GGGGGG", "#ZZZZZZ", "#1234", "FFFFFF", 
	                    	    "#12345G", "#1234567", "rgb(255,0,0)",
	                    	    // Vulnerable Colors
	                    	    "#FFFFFF<script>alert('XSS');</script>", "#000000' OR '1'='1'", 
	                    	    "#FF5733'; DROP TABLE colors;", "javascript:alert('Hacked!')", 
	                    	    "#<script>alert(1)</script>", "#123ABC'; EXEC xp_cmdshell('dir'); --", 
	                    	    "#123456' UNION SELECT color_code FROM palette --", "#FF0000' OR ''='", 
	                    	    "url(http://evil.com/hack.png)", "#FAFAFA/*SQLi*/"
			},
			
			
			{
			    // Valid Times
			    "00:00", "12:34", "23:59", "06:45", "18:30", "09:09", "15:15", "21:21", "11:11", "04:44",
			    // Invalid Times
			    "", "24:00", "12:60", "99:99", "12:345", "abc:def", "00-00", "12:34:67", "12.34", "midnight",
			    // Vulnerable Times
			    "' OR '1'='1' --", "12:34'; DROP TABLE users;", "00:00<script>alert('XSS');</script>",  
			    "\"; EXEC xp_cmdshell('shutdown -s'); --",  "'; SELECT * FROM sensitive_data --", 
			    "'; rm -rf / --", "javascript:alert('Hacked!')", "12:34' OR ''='", 
			    "12:34 UNION SELECT password FROM users --",  "12:34'--"
			},
			
			
			{
			    "2025-01", "1999-12", "2000-06", "2024-09", "2010-03", "2030-07", "2023-05", "1980-11", "2077-09", "2005-04", // Valid
			    "", "2025-13", "1999-00", "abcd-ef", "2024/06", "June 2024", "99-99", "2025-6", "2025.07", "20-2024", // Invalid
			    "' OR '1'='1' --", "2024-06'; DROP TABLE users;", "2025-01<script>alert('XSS');</script>", 
			    "\"; EXEC xp_cmdshell('shutdown -s'); --", "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", 
			    "javascript:alert('Hacked!')", "2025-06' OR ''='", "2025-06 UNION SELECT password FROM users --", "2025-06'--" // Vulnerable
			},
			
			
			{
			    "2025-W01", "1999-W12", "2000-W26", "2024-W09", "2010-W52", "2030-W34", "2023-W15", "1980-W44", "2077-W50", "2005-W20", // Valid
			    "", "2025-W53", "1999-W00", "abcd-Wef", "2024/W09", "Week 12 of 2024", "99-W99", "2025-W6", "2025.W07", "2025-07", // Invalid
			    "' OR '1'='1' --", "2024-W06'; DROP TABLE users;", "2025-W01<script>alert('XSS');</script>", 
			    "\"; EXEC xp_cmdshell('shutdown -s'); --", "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", 
			    "javascript:alert('Hacked!')", "2025-W06' OR ''='", "2025-W06 UNION SELECT password FROM users --", "2025-W06'--" // Vulnerable
			},
			
			{
			    "document.pdf", "image.jpg", "report.docx", "spreadsheet.xlsx", "presentation.pptx", "archive.zip", 
			    "script.js", "stylesheet.css", "data.json", "notes.txt", // Valid
			    "", "nofile", "corruptfile.", "invalidfile.exe", "malware.bat", "script.sh", "virus.com", 
			    "unknownfile.xyz", "database.sql", "backup.tar.gz", // Invalid
			    "' OR '1'='1' --.txt", "file.php'; DROP TABLE users;", "<script>alert('XSS');</script>.html", 
			    "\"; EXEC xp_cmdshell('shutdown -s'); --.exe", "'; SELECT * FROM sensitive_data --.csv", "'; rm -rf / --.sh", 
			    "javascript:alert('Hacked!').js", "file' OR ''='.jpg", "file UNION SELECT password FROM users --.png", "file'--.pdf" // Vulnerable
			},
			
			
			{
			    "on", "off", "checked", "unchecked", "true", "false", "1", "0", "yes", "no", // Valid
			    "", "checked checked", "yesno", "maybe", "abc", "1.5", "onoff", "truefalse", "toggle", "selected", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "checkbox' OR ''='", "checkbox UNION SELECT password FROM users --" // Vulnerable
			},
			
			
			{
			    "yes", "no", "male", "female", "option1", "option2", "option3", "checked", "unchecked", "on", // Valid
			    "", "yesno", "maybe", "undefined", "abc", "random", "truefalse", "selected", "invalid_option", "onoff", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "radio' OR ''='", "radio UNION SELECT password FROM users --" // Vulnerable
			},
			
			
			{
			    "Submit", "Send", "Next", "Continue", "Finish", "Save", "Login", "Register", "Upload", "Search", // Valid
			    "", "     ", "submit submit", "next next", "send send send", "upload upload", "register!", "null", "12345", "check", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "submit' OR ''='", "submit UNION SELECT password FROM users --" // Vulnerable
			},
			
			
			{
		    "Reset", "Clear", "Start Over", "Refresh", "Erase", "Clear All", "Reset Form", "Undo", "Delete All", "Revert", // Valid
		    "", "     ", "reset reset", "clear clear", "start start", "delete delete", "form reset!", "null", "12345", "check", // Invalid
		    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
		    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
		    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
		    "reset' OR ''='", "reset UNION SELECT password FROM users --" // Vulnerable
			},
			
			
			
			
			{
			    "Submit", "Click Me", "Proceed", "Next", "Confirm", "OK", "Go", "Cancel", "Search", "Save", // Valid
			    "", "     ", "button button", "next next", "click me click", "submit submit", "save save", "check", "12345", "confirm confirm", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "button' OR ''='", "button UNION SELECT password FROM users --" // Vulnerable
			},
			
			
			
			 {
			    "image1.jpg", "picture.png", "logo.gif", "banner.svg", "photo.jpeg", "icon.bmp", "thumbnail.webp", "header.tiff", "background.jpg", "avatar.png", // Valid
			    "", "image1", "picture.", "logo.image", "file.txt", "noimage.bmp", "image1.docx", "document.pdf", "data.csv", "icon.exe", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "image.jpg' OR ''='", "image.png UNION SELECT password FROM users --" // Vulnerable
			},
			 
			 
			 {
			    "apple", "banana", "java programming", "openai", "machine learning", "web development", 
			    "2025 technology", "data science", "coding tutorials", "learn java", // Valid
			    "", "     ", "apple?banana", "12345", "!!!!!!", "java&openai", "!!!", "<script>alert('XSS')</script>", "hello world@!", "search query?=", // Invalid
			    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
			    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
			    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
			    "search' OR ''='", "search UNION SELECT password FROM users --" // Vulnerable
			}

			
			
	       
	       
	                    	
	};
	
	String[] allText = {"JohnDoe", "HelloWorld", "JavaRocks", "Valid123", "TextData", "Username", "RandomString", "TestText", "AlphaBeta", "BravoCharlie",
            "", "   ", "\n", "\t", null, "💩", "超长文本输入", "🔥🔥🔥🔥🔥🔥🔥", "NameWith#Symbol", "Spaces   ",
            "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; DROP TABLE users; --", "javascript:alert(1)", "../etc/passwd", 
            "SELECT * FROM users;", "'; EXEC xp_cmdshell('dir'); --", "\"; rm -rf / --", "' OR ''='", "base64_decode('aGFja2Vk')"};

//Repeat the same pattern for other input types

	String[] allNumbers = {"0", "1", "10", "999", "-5", "100", "-100", "2147483647", "-2147483648", "42",
               "", "abc", "3.14", "one", "NaN", "--100", "123abc", "Infinity", "- 999", "9.99.99",
               "999999999 OR 1=1", "' UNION SELECT null, username, password FROM users --", "1; DROP TABLE students;", "' OR ''='",
               "1/0", "'; EXEC xp_cmdshell('shutdown -s'); --", "4294967296", "1E400", "-9999999999999999999", "1000000000*"};

	String[] allEmails = {"user@example.com", "admin@domain.com", "test123@mail.org", "info@website.net", "hello@company.io", "support@service.dev",
              "first.last@edu.edu", "contact@business.biz", "name123@gmail.com", "user+alias@domain.com",
              "", "user@", "user@.com", "@domain.com", "user@domain", "user@@domain.com", "user@domain..com", "user@domain,com",
              "user@domain com", "user@.domain.com",
              "' OR '1'='1' --", "admin' --", "' UNION SELECT email, password FROM users --", "1' OR '1'='1'", "'; DROP TABLE emails;",
              "\"; EXEC xp_cmdshell('dir'); --", "' OR '1'='1' /*", "user@example.com<script>alert('XSS');</script>",
              "john.doe@evil.com'><script>stealCookies()</script>", "email@domain.com'--"};

	String[] allPasswords = {"SecureP@ss1", "Passw0rd!", "Random@123", "Qwerty#987", "Hello@World99", "GoodPass88*", "A1b2C3d4*", "My$tr0ngP@ss",
                 "Strongest@432", "SafeP@ssword999",
                 "", "password", "123456", "abcdef", "qwerty", "letmein", "iloveyou", "password123", "admin", "root",
                 "' OR '1'='1' --", "'; DROP TABLE users;", "admin' --", "' UNION SELECT password FROM users --", "' OR ''='",
                 "\" OR \"\"=\"", "'; EXEC xp_cmdshell('dir'); --", "password'><script>alert('XSS');</script>", "' OR 1=1#", "' --"};

	// Date Inputs
	String[] allDates = {
	    // Valid Dates
	    "2025-12-31", "1999-01-01", "2000-02-29", "2024-06-15", "2030-07-20", 
	    "2023-03-10", "2010-05-05", "1980-11-11", "2077-09-09", "2005-04-04",
	    // Invalid Dates
	    "", "31-12-2025", "2024/06/15", "June 15, 2024", "2025-13-01", 
	    "2025-00-12", "2025-02-30", "abcd-ef-gh", "2025-06-40", "0000-00-00",
	    // Vulnerable Dates
	    "' OR '1'='1' --", "'; DROP TABLE dates;", "0000-00-00'; DELETE FROM users; --", 
	    "01-01-1970' OR '1'='1'", "2025-06-15<script>alert('XSS');</script>", 
	    "'; EXEC xp_cmdshell('shutdown -s'); --", "' UNION SELECT birthday, password FROM users --", 
	    "2025-01-01' /*", "2025-06-06' OR 'x'='x'", "2025-06-15'--"
	};

	// URL Inputs
	String[] allURLs = {
	    // Valid URLs
	    "https://example.com", "http://domain.com", "https://www.google.com", 
	    "https://www.facebook.com", "https://blog.website.org", "http://news.site.net", 
	    "https://secure-page.io", "https://user.dashboard.com", "https://app.service.dev", 
	    "http://123.456.789.101",
	    // Invalid URLs
	    "", "htp:/example.com", "https:/example", "ftp://invalid.url", "http:/missing-slash.com", 
	    "https//wrong-format", "www.missinghttp.com", "site.com/no-http", "://invalid.com", 
	    "javascript:alert(1)",
	    // Vulnerable URLs
	    "javascript:alert('XSS')", "data:text/html;base64,PHNjcmlwdD5hbGVydCgnSGFja2VkIScpPC9zY3JpcHQ+", 
	    "http://evil.com/steal?cookie=document.cookie", "'; DROP TABLE urls;", 
	    "https://malicious.com/?param=<script>alert(1)</script>", "https://example.com' OR '1'='1'", 
	    "https://mybank.com?redirect=http://attacker.com", "http://%2525%252E%2525%252E%2525%252E%2525%252E/etc/passwd", 
	    "file:///etc/passwd", "ftp://evil.com"
	};

	// Color Inputs
	String[] allColors = {
	    // Valid Colors
	    "#FF5733", "#000000", "#FFFFFF", "#123ABC", "#00FF00", "#ABCDEF", 
	    "#999999", "#FFA500", "#800080", "#008080",
	    // Invalid Colors
	    "", "red", "#12", "#GGGGGG", "#ZZZZZZ", "#1234", "FFFFFF", 
	    "#12345G", "#1234567", "rgb(255,0,0)",
	    // Vulnerable Colors
	    "#FFFFFF<script>alert('XSS');</script>", "#000000' OR '1'='1'", 
	    "#FF5733'; DROP TABLE colors;", "javascript:alert('Hacked!')", 
	    "#<script>alert(1)</script>", "#123ABC'; EXEC xp_cmdshell('dir'); --", 
	    "#123456' UNION SELECT color_code FROM palette --", "#FF0000' OR ''='", 
	    "url(http://evil.com/hack.png)", "#FAFAFA/*SQLi*/"
	};

	// Time Inputs
	String[] allTimes = {
	    // Valid Times
	    "00:00", "12:34", "23:59", "06:45", "18:30", "09:09", "15:15", "21:21", "11:11", "04:44",
	    // Invalid Times
	    "", "24:00", "12:60", "99:99", "12:345", "abc:def", "00-00", "12:34:67", "12.34", "midnight",
	    // Vulnerable Times
	    "' OR '1'='1' --", "12:34'; DROP TABLE users;", "00:00<script>alert('XSS');</script>",  
	    "\"; EXEC xp_cmdshell('shutdown -s'); --",  "'; SELECT * FROM sensitive_data --", 
	    "'; rm -rf / --", "javascript:alert('Hacked!')", "12:34' OR ''='", 
	    "12:34 UNION SELECT password FROM users --",  "12:34'--"
	};

	// Month Inputs
	String[] allMonths = {
	    "2025-01", "1999-12", "2000-06", "2024-09", "2010-03", "2030-07", "2023-05", "1980-11", "2077-09", "2005-04", // Valid
	    "", "2025-13", "1999-00", "abcd-ef", "2024/06", "June 2024", "99-99", "2025-6", "2025.07", "20-2024", // Invalid
	    "' OR '1'='1' --", "2024-06'; DROP TABLE users;", "2025-01<script>alert('XSS');</script>", 
	    "\"; EXEC xp_cmdshell('shutdown -s'); --", "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", 
	    "javascript:alert('Hacked!')", "2025-06' OR ''='", "2025-06 UNION SELECT password FROM users --", "2025-06'--" // Vulnerable
	};

	// Week Inputs
	String[] allWeeks = {
	    "2025-W01", "1999-W12", "2000-W26", "2024-W09", "2010-W52", "2030-W34", "2023-W15", "1980-W44", "2077-W50", "2005-W20", // Valid
	    "", "2025-W53", "1999-W00", "abcd-Wef", "2024/W09", "Week 12 of 2024", "99-W99", "2025-W6", "2025.W07", "2025-07", // Invalid
	    "' OR '1'='1' --", "2024-W06'; DROP TABLE users;", "2025-W01<script>alert('XSS');</script>", 
	    "\"; EXEC xp_cmdshell('shutdown -s'); --", "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", 
	    "javascript:alert('Hacked!')", "2025-W06' OR ''='", "2025-W06 UNION SELECT password FROM users --", "2025-W06'--" // Vulnerable
	};

	// File Inputs
	String[] allFiles = {
	    "document.pdf", "image.jpg", "report.docx", "spreadsheet.xlsx", "presentation.pptx", "archive.zip", 
	    "script.js", "stylesheet.css", "data.json", "notes.txt", // Valid
	    "", "nofile", "corruptfile.", "invalidfile.exe", "malware.bat", "script.sh", "virus.com", 
	    "unknownfile.xyz", "database.sql", "backup.tar.gz", // Invalid
	    "' OR '1'='1' --.txt", "file.php'; DROP TABLE users;", "<script>alert('XSS');</script>.html", 
	    "\"; EXEC xp_cmdshell('shutdown -s'); --.exe", "'; SELECT * FROM sensitive_data --.csv", "'; rm -rf / --.sh", 
	    "javascript:alert('Hacked!').js", "file' OR ''='.jpg", "file UNION SELECT password FROM users --.png", "file'--.pdf" // Vulnerable
	};

	// Checkbox Inputs
	String[] allCheckboxes = {
	    "on", "off", "checked", "unchecked", "true", "false", "1", "0", "yes", "no", // Valid
	    "", "checked checked", "yesno", "maybe", "abc", "1.5", "onoff", "truefalse", "toggle", "selected", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "checkbox' OR ''='", "checkbox UNION SELECT password FROM users --" // Vulnerable
	};

	// Radio Inputs
	String[] allRadios = {
	    "yes", "no", "male", "female", "option1", "option2", "option3", "checked", "unchecked", "on", // Valid
	    "", "yesno", "maybe", "undefined", "abc", "random", "truefalse", "selected", "invalid_option", "onoff", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "radio' OR ''='", "radio UNION SELECT password FROM users --" // Vulnerable
	};

	// Submit Inputs
	String[] allSubmits = {
	    "Submit", "Send", "Next", "Continue", "Finish", "Save", "Login", "Register", "Upload", "Search", // Valid
	    "", "     ", "submit submit", "next next", "send send send", "upload upload", "register!", "null", "12345", "check", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "submit' OR ''='", "submit UNION SELECT password FROM users --" // Vulnerable
	};

	// Reset Inputs
	String[] allResets = {
	    "Reset", "Clear", "Start Over", "Refresh", "Erase", "Clear All", "Reset Form", "Undo", "Delete All", "Revert", // Valid
	    "", "     ", "reset reset", "clear clear", "start start", "delete delete", "form reset!", "null", "12345", "check", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "reset' OR ''='", "reset UNION SELECT password FROM users --" // Vulnerable
	};

	// Button Inputs
	String[] allButtons = {
	    "Submit", "Click Me", "Proceed", "Next", "Confirm", "OK", "Go", "Cancel", "Search", "Save", // Valid
	    "", "     ", "button button", "next next", "click me click", "submit submit", "save save", "check", "12345", "confirm confirm", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "button' OR ''='", "button UNION SELECT password FROM users --" // Vulnerable
	};

	// Image Inputs
	String[] allImages = {
	    "image1.jpg", "picture.png", "logo.gif", "banner.svg", "photo.jpeg", "icon.bmp", "thumbnail.webp", "header.tiff", "background.jpg", "avatar.png", // Valid
	    "", "image1", "picture.", "logo.image", "file.txt", "noimage.bmp", "image1.docx", "document.pdf", "data.csv", "icon.exe", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "image.jpg' OR ''='", "image.png UNION SELECT password FROM users --" // Vulnerable
	};

	// Search Inputs
	String[] allSearches = {
	    "apple", "banana", "java programming", "openai", "machine learning", "web development", 
	    "2025 technology", "data science", "coding tutorials", "learn java", // Valid
	    "", "     ", "apple?banana", "12345", "!!!!!!", "java&openai", "!!!", "<script>alert('XSS')</script>", "hello world@!", "search query?=", // Invalid
	    "<script>alert('XSS');</script>", "' OR '1'='1' --", "\"; EXEC xp_cmdshell('shutdown -s'); --", 
	    "'; SELECT * FROM sensitive_data --", "'; rm -rf / --", "javascript:alert('Hacked!')", 
	    "<iframe src='malicious.com'></iframe>", "<script>window.location='http://malicious.com'</script>", 
	    "search' OR ''='", "search UNION SELECT password FROM users --" // Vulnerable
	};

	
	
    public static Inputse getInputs() {
    	if(inputs == null)
    		inputs = new Inputse();
		return inputs;
	}
    
}
