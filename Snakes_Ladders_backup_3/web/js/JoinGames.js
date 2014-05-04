/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 $(document).ready(function(){
          $('#u').focus(function(){
            $('#u').css('background','yellow');
                $('#un').html('');
            }).blur(function(){
             $('#u').css('background','white');
            match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#u').val();
            if(uname==''){
            $('#u').css('background','pink');
                  $('#un').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#un').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             }
            });
            
           
            $('#b').focus(function(){
            $('#b').css('background','yellow');
                $('#bn').html('');
            }).blur(function(){
             $('#b').css('background','white');
            match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var bname = $('#b').val();
            if(bname==''){
            $('#b').css('background','pink');
                  $('#bn').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(bname)){
            $('#bn').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             }
            });
            $('#p').focus(function(){
             $('#p').css('background','yellow');
              $('#pas').html('');
            }).blur(function(){
             $('#p').css('background','white');
            var pname = $('#p').val();
            if(pname==''){
             $('#p').css('background','pink');
                  $('#pas').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pname.match(/^[a-zA-Z0-9]/)){         
                 if(pname.length<5 || uname.length>10){
                   $('#pas').html('<font color="white" style="font-size:9pt">Password Must be 5 to 10 Characters Long</font>');
                 }
             }else{
              $('#pas').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
            });
            
            $('#su').click(function(){
                
             var uname = $('#u').val();
             
               var pass = $('#p').val();
              if(uname==''){
            $('#u').css('background','pink');
                  $('#un').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#un').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             }          
             
          
            match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var bname = $('#b').val();
            if(bname==''){
            $('#b').css('background','pink');
                  $('#bn').html('<font color="white" style="font-size:9pt">Boardname Cannot Be Empty</font>');
            }else if(!match.test(bname)){
            $('#bn').html('<font color="white" style="font-size:9pt">Enter a Valid Boardname</font>');
             }
            
             
              if(pass==''){
             $('#p').css('background','pink');
                  $('#pas').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[a-zA-Z0-9]/)){         
             
             }else{
              $('#pas').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
                 var color = $('#co').val();
                if(color==''){
                  $('#c').html('<font color="white" style="font-size:9pt">Color Cannot be Empty</font>');
                }
                
                if(uname==''&&pass==''&&color=='')
                    {
                        return false;
                    }
                    else
                        {
                            return true;
                        }
             });
             
             
             });
      
