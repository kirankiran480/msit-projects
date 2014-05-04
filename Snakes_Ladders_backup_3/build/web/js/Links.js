/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function()
{
 
 $('nav').click(function()
 {
     $('#heading').slideUp('fast');
 });
 
 $('nav').dblclick(function()
 {
     $('#heading').slideDown('fast');
 });
 
    $('#login').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
});

$('#login').mouseleave(function()
{
     $(this).css({'text-decoration':'none','color':'white'});  
});

$('#register').mouseenter(function()
{
   $(this).css({'text-decoration':'underline','color':'lightgreen'});
   
});

$('#register').mouseleave(function()
{
     $(this).css({'text-decoration':'none','color':'white'});
    
});

$('#about').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
   
});

$('#about').mouseleave(function()
{
     $(this).css({'text-decoration':'none','color':'white'});
    
});

$('#instruct').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
    
});

$('#instruct').mouseleave(function()
{
     $(this).css({'text-decoration':'none','color':'white'});
     
});

$('#create').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
    
});

$('#create').mouseleave(function()
{
     $(this).css({'text-decoration':'none','color':'white'});
     
});

$('#join').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
   
});

$('#join').mouseleave(function()
{
    $(this).css({'text-decoration':'none','color':'white'});
    
});

$('#contact').mouseenter(function()
{
    $(this).css({'text-decoration':'underline','color':'lightgreen'});
    
});

$('#contact').mouseleave(function()
{
    $(this).css({'text-decoration':'none','color':'white'});
  
});
});
