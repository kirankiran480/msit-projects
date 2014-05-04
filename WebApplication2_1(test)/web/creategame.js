

function validateform()
        {
             //alert("validation"); 
			 
			var board=document.forms ["newgame"]["boardname"].value;
    		if( board==='' || (/^\W/).test(board) || (/\s/).test(board))
   			{
     		 	alert( "Please provide valid board name!" );
     			//document.myForm.Name.focus() ;
    			return false;
   			}
           
    		var pass_len = document.forms["newgame"]["password"].value.length; 
			var pass =  document.forms["newgame"]["password"].value;
    		if (pass_len === 0)  
    		{  
        	   alert("Password should not be empty ");  
         
         	   return false;  
    		}  
    		if(pass_len > 10 || pass_len < 5)
        	{
             			  alert("password length should be 5 to 10 characters");
						  return false;
        	}
			
			  var selectcombo=document.newgame.totalplayers;
        if(selectcombo.selectedIndex===0)
            {
                alert("choose number of players");
                return false;
            }
		var radios = document.getElementsByName("diecolor");
        var formValid = false;

        var i = 0;
        while (formValid===false && i<radios.length) 
        {
            if (radios[i].checked) 
                formValid = true;
            i++;        
        }
    if (formValid===false) 
        {
            alert("choose a die color!");
            return false;
        }

			return true;
	  }
