
$(function() {
	// Wire up the on-click handlers for some ui elements
	wire_click_events();
});

// Defines handlers for click events.
function wire_click_events() {
	$('#btn_run').bind('click', function(event) {
		btnrun_onclick(event);
	});
}

// On-click handler for run button.
function btnrun_onclick(event) {
	$('#iframe_main').attr(
		{
			'src':'test'
		}
	);
}