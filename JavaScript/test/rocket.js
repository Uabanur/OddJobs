var Rocket = function() 
{
	this.h = 15;
	this.w = 4;
	this.pos = createVector(width/2, height-10);
	this.vel = createVector(0, 0);
	this.acc = createVector(0, 0);
	this.moves = new Array(200);
	this.angle = 0;
	this.index = 0;
	this.alive = true;
	this.finished = false;
	this.fitness = 0;




	for(var i = 0; i < this.moves.length; i++)
	{
		if(random(1) < 0.95 && arguments.length > 0)
			this.moves[i] = arguments[0].moves[i];
		else
			this.moves[i] = createVector(random(0.5), random(TWO_PI));
	}



	this.update = function(obstalce)
	{
		if(!this.alive || this.finished)
			return;

		var force = p5.Vector.fromAngle(this.moves[this.index].y);
		force.setMag(this.moves[this.index].x);

		if(++this.index >= this.moves.length)
			this.index = 0;

		this.acc.add(force);
		this.vel.add(this.acc);
		this.vel.limit(5);
		this.pos.add(this.vel);
		this.angle = this.vel.heading();

		if(this.pos.x > width || this.pos.x < 0 || this.pos.y > height || this.pos.y < 0 || 
			(this.pos.y > obstacle.y - obstacle.h/2 && this.pos.y < obstacle.y + obstacle.h/2 &&
				this.pos.x > obstacle.x - obstacle.w/2 && this.pos.x < obstacle.x + obstacle.w/2))
		{
			this.alive = false;
		}

		this.fitness -= 5;
	}

	this.show = function() 
	{
		

		rectMode(CENTER);
		fill(255, 50, 100, 130);

		push();
		translate(this.pos.x, this.pos.y);
		rotate(this.angle + PI/2);
		rect(0, 0, this.w, this.h);
		pop();
	}

	this.goal = function(target)
	{
		var d = dist(this.pos.x, this.pos.y, target.x, target.y);

		if(d < target.r - 5)
			this.finished = true;


		this.fitness = height-d;	
			
	}
}