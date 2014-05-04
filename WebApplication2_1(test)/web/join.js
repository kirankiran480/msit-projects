

function validateform()
        {
             //alert("validation"); 
			 var name=document.forms ["joingame"]["username"].value;
             if(name='' || (/^\W/).test(name) || (/\s/).test(name))
   			 {
     		  	 alert( "Please provide valid username!" );
     			 		//document.myForm.Name.focus() ;
     			return false;
   			}
			var board=document.forms ["joingame"]["boardname"].value;
    		if( board=='' || (/^\W/).test(board) || (/\s/).test(board))
   			{
     		 	alert( "Please provide valid board name!" );
     			//document.myForm.Name.focus() ;
    			return false;
   			}
           
    		var pass_len = document.forms["joingame"]["password"].value.length; 
			var pass =  document.forms["joingame"]["password"].value;
    		if (pass_len == 0)  
    		{  
        	   alert("Password should not be empty ");  
         
         	   return false;  
    		}  
    		if(pass_len > 10 || pass_len < 5)
        	{
             			  alert("password length should be 5 to 10 characters")
						  return false;
        	}
			
		 
		var radios = document.getElementsByName("diecolor");
        var formValid = false;

        var i = 0;
        while (formValid==false && i<radios.length) 
        {
            if (radios[i].checked) 
                formValid = true;
            i++;        
        }
    if (formValid==false) 
        {
            alert("choose a die color!");
            return false;
        }

			return true;
	  }
