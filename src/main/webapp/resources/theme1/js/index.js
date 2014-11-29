
// Initialize page once it's done loading.
$(function() {
	// Wire up the on-click handlers for some ui elements
	wire_click_events();
});

// Defines handlers for click events.
function wire_click_events() {
	$('#btn_test1').click(function(e) {
		btntest1_onclick(e);
	});
	$('#btn_test2').click(function(e) {
		btntest2_onclick(e);
	});
}

// On-click handler for test1 button.
function btntest1_onclick(event) {
	//alert('btntest1_onclick');
	$('#iframe_main').attr('src', 'home/');
}

//On-click handler for test2 button.
function btntest2_onclick(event) {
	$('#iframe_main').attr('src', 'http://swellergis.dnsdojo.com/');
	//$('#iframe_main').attr('src', 'test/');
}

