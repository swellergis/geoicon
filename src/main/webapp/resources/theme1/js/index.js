
// Initialize page once it's done loading.
$(function() {
	$('#iframe_main').attr('src', 'home/');
	// Wire up the on-click handlers for some ui elements
	wire_click_events();
});

// Defines handlers for click events.
function wire_click_events() {
	$('#btn_test1').click(function(e) {
		btntest1_onclick(e);
	});
}

// On-click handler for test1 button.
function btntest1_onclick(event) {
	//alert('btntest1_onclick');
	$('#iframe_main').attr('src', 'home/');
}

//On-click handler for test2 button.
function btntest2_onclick(event) {
	$('#iframe_main').attr('src', 'http://boulderdem.dnsdojo.com/map/index.html');
	//$('#iframe_main').attr('src', 'test/');
}

