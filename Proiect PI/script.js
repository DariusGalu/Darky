$(document).ready(function(){
$('#Geoagiu area').hover(
	function () { 
		var coords = $(this).attr('coords').split(',');
		var width = $('.Geoagiu-container').width();
		var height = $('.Geoagiu-container').height();
		$('.Geoagiu-container .map-selector').addClass('hover').css({
			'left': coords[0]+'px',
			'top': coords[1] + 'px',
			'right': width - coords[2],
			'bottom': height - coords[3]
		})
	 },
	function () { 
		$('.Geoagiu-container .map-selector').removeClass('hover').attr('style','');
	}
)
})