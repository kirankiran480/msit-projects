/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function()
{
    $('#luname').focus(function(){
            $('#luname').css('background','yellow');
                $('#lun').html('');
            }).blur(function(){
             $('#luname').css('background','white');
            match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#luname').val();
            if(uname==''){
            $('#luname').css('background','pink');
                  $('#un').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#un').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             }
            });
            
            $('#lp').focus(function(){
             $('#lp').css('background','yellow');
              $('#pas').html('');
            }).blur(function(){
             $('#lp').css('background','white');
            var pname = $('#lp').val();
            if(pname==''){
             $('#lp').css('background','pink');
                  $('#pas').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pname.match(/^[a-zA-Z0-9]/)){         
                 if(pname.length<5 || uname.length>10){
                   $('#pas').html('<font color="white" style="font-size:9pt">Password Must be 5 to 10 Characters Long</font>');
                 }
             }else{
              $('#pas').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
            });
            
              $('#lsub').click(function(){
                
             var uname = $('#luname').val();
             
               var pass = $('#lp').val();
              if(uname==''){
            $('#luname').css('background','pink');
                  $('#un').html('<font color="white" style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#un').html('<font color="white" style="font-size:9pt">Enter a Valid Username</font>');
             }               
             
              if(pass==''){
             $('#lp').css('background','pink');
                  $('#pas').html('<font color="white" style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[a-zA-Z0-9]/)){         
             
             }else{
              $('#pas').html('<font color="white" style="font-size:9pt">Enter a Valid Password</font>');
             }
             
             if(uname==''&&pass=='')
                    {
                        return false;
                    }
                    else
                        {
                            return true;
                        }
             });
});


