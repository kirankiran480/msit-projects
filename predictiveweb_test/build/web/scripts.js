/** External Links **/

function externalLinks() { if (!document.getElementsByTagName) return; var anchors = document.getElementsByTagName("a"); for (var i=0; i<anchors.length; i++) { var anchor = anchors[i]; if (anchor.getAttribute("href") && anchor.getAttribute("rel") == "external") anchor.target = "_blank"; } } window.onload = externalLinks;

/** SuckerFish Menu **/

$(document).ready(function(){ $('ul.dropdown').superfish({ autoArrows: false }); });

/** Gallery **/

function slideSwitch()
{
	var $active = $('#slideshow IMG.active');
    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');
    var $next =  $active.next().length ? $active.next() : $('#slideshow IMG:first');
    $active.addClass('last-active');
    $next.css({opacity: 0.0}) .addClass('active') .animate({opacity: 1.0}, 1000, function() { $active.removeClass('active last-active'); });
}

$(function() { setInterval( "slideSwitch()", 5000 ); });

