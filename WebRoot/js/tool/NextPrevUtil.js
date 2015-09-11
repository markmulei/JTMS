var nextprev = function(panel, direction, btn) {
	var layout = panel.getLayout();
	layout[direction]();
};