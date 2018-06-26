var mic, fft;

function setup() {
   createCanvas(710,600);

   mic = new p5.AudioIn();
   mic.start();
   fft = new p5.FFT();
   fft.setInput(mic);

   
   textSize(32);
}

function draw() {
   background(200);

   // var spectrum = fft.analyze();
   // var amp = 0;
   // var freq = 0;
   // noFill();
   // beginShape();
   // for (i = 0; i<spectrum.length; i++) {
   //    if(spectrum[i] > amp)
   //    {
   //       amp = spectrum[i];
   //       freq = i;
   //    }

   //  vertex(i, map(spectrum[i], 0, 255, height, 0) );
   // }
   // endShape();

   // fill(0);
   // text("Dominant frequency: " + freq, 100, 100);
   // text("Dominant amplitude: " + amp, 100, 130);

   // fill(255, 0, 0);
   // ellipse(freq, map(amp, 0, 255, height, 0), 20, 20);

   var waveform = fft.waveform();
   noFill();
   beginShape();
   stroke(255,0,0); // waveform is red
   strokeWeight(1);
   for (var i = 0; i< waveform.length; i++){
    var x = map(i, 0, waveform.length, 0, width);
    var y = map( waveform[i], -1, 1, 0, height);
    vertex(x,y);
   }
   endShape();
   
}