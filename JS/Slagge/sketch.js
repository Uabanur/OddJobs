
var angle = 0;
var diff = 0.8;
var step;
var rad = 24;
var ical = 17;

function setup() 
{
	createCanvas(100, 100);
	background(0);
	step = PI/4;
}

function draw() 
{
	frameRate(12);
	background(0, 0, 0, 100);

	fill(255, 100);
	noStroke();
	ellipse(Math.sin(angle)*rad + width/2, Math.cos(angle)*rad + height/2, ical, ical);
	angle -= step;
}

