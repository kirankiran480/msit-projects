/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
            $('#uname').focus(function(){
            $('#uname').css('background','yellow');
                $('#us').html('');
            }).blur(function(){
             $('#uname').css('background','white');
            match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#uname').val();
            if(uname==''){
            $('#uname').css('background','pink');
                  $('#us').html('<font color="white"  style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#us').html('<font color="white"  style="font-size:9pt">Enter a Valid Username</font>');
             }
            });
            
            $('#bname').focus(function(){
             $('#bname').css('background','yellow');
              $('#bn').html('');
            }).blur(function(){
             $('#bname').css('background','white');
              match = /^\s*[a-zA-Z0-9,\s]+\s*$/;
            var uname = $('#bname').val();
            if(uname==''){
             $('#bname').css('background','pink');
                  $('#bn').html('<font color="white"  style="font-size:9pt">Board Name Cannot Be Empty</font>');
            } else if(!match.test(uname)){
             $('#bn').html('<font color="white"  style="font-size:9pt">Enter a Valid BoardName</font>');
             }
            });
           
       

            
            $('#pass').focus(function(){
             $('#pass').css('background','yellow');
              $('#pa').html('');
            }).blur(function(){
             $('#pass').css('background','white');
            var pass = $('#pass').val();
            if(pass==''){
             $('#pass').css('background','pink');
                  $('#pa').html('<font color="white"  style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[a-zA-Z0-9]/)){         
                   if(pass.length<5 || pass.length>10){
                   $('#pa').html('<font color="white"  style="font-size:9pt">Password Must be 5 to Characters Long</font>');
                 }
             }else{
                 
              $('#pa').html('<font color="white"  style="font-size:9pt">Enter a Valid Password</font>');
             }
             
            });
            
             $('#crg').click(function(){
             var uname = $('#uname').val();
              var bname = $('#bname').val();
              
               var pass = $('#pass').val();
              if(uname==''){
            $('#uname').css('background','pink');
                  $('#us').html('<font color="white"  style="font-size:9pt">Username Cannot Be Empty</font>');
            }else if(!match.test(uname)){
            $('#us').html('<font color="white"  style="font-size:9pt">Enter a Valid Username</font>');
             }
              if(bname==''){
             $('#bname').css('background','pink');
                  $('#bn').html('<font color="white"  style="font-size:9pt">Board Name Cannot Be Empty</font>');
            } else if(!match.test(bname)){
             $('#bn').html('<font color="white"  style="font-size:9pt">Enter a Valid BoardName</font>');
             }
              
           var selected=$('#num').val();
        if(selected=='')
            {
                $('np').html('<font color="white"  style="font-size:9pt">Select atleast one player</font>');
            }
   
              if(pass==''){
             $('#pass').css('background','pink');
                  $('#pa').html('<font color="white"  style="font-size:9pt">Password Cannot Be Empty</font>');
            }else  if(pass.match(/^[a-zA-Z0-9]/)){         
             
             }else{
                  
              $('#pa').html('<font color="white"  style="font-size:9pt">Enter a Valid Password</font>');
             }
               
               var color = $('#color').val();
                if(color==''){
                  $('#se').html('<font color="white"  style="font-size:9pt">Color Cannot be Empty</font>');
                }
             
                
                if(uname!=''&&bname!=''&&selected!=''&&pass!=''&&color!='')
                    {
                        return true;
                    }
                    else
                        {
                            return false;
                        }
             });
             
             
  });         