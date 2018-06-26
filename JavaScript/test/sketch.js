var rockets = [];
var target;
var obstacle;

function setup() {
  	createCanvas(400, 300);
  	background(51);
	
	target = new Target(width/2, height/10);	
	obstacle = new Obstacle(width/2, height/2);

  	for(var i = 0; i < 100; i++)
  	{
  		rockets[i] = new Rocket();
  	}
}

function draw() {
	background(51);
	target.show();
	obstacle.show();

	for(var i = 0; i < rockets.length; i++)
	{
		rockets[i].update(obstacle);
		rockets[i].show();
		rockets[i].goal(target);
	}

	if(frameCount % 200 == 0)
		newGeneration();

	fill(255);
	text(floor(getFrameRate()), 10, 20);

}

var newGeneration = function()
{
	var newRockets = [];
	var index = 0;
	while(newRockets.length < 100)
	{
		if(index >= rockets.length)
			break;

		var x = rockets[index++];
			if(x.alive)
			{
				if(x.finished)
					for(var i = 0; i < 20; i++)
					{
						newRockets.push(new Rocket(x));
					}
				else if(x.fitness > 100)
					for(var i = 0; i < 10; i++)
					{
						newRockets.push(new Rocket(x));
					}
				else 
					for(var i = 0; i < 5; i++)
					{
						newRockets.push(new Rocket(x));
					}
			} else {
				newRockets.push(new Rocket());
			}

		

	}

	rockets = newRockets;
}



var Target = function(x, y) {

	this.x = x;
	this.y = y;
	this.r = 20;

	this.show = function(){
		fill('green');
		noStroke();
		ellipse(this.x,this.y, this.r, this.r);
	}

}

var Obstacle = function(x, y) {

	this.x = x;
	this.y = y;
	this.h = 20;
	this.w = 100

	this.show = function(){
		fill('gray');
		noStroke();
		rect(this.x,this.y, this.w, this.h);
	}

}