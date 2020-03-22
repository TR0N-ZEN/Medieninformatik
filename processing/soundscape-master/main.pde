import processing.sound.*;
float frequency, amplitude, panning;
SinOsc tone = new SinOsc(this);                    //new oscilator object of name "tone"
boolean amplificationcontrol = true, stop = false;

void setup(){
  size(700,400);
  tone.play(0,0);
}

void draw(){
  frequency = map(mouseY, height, 0, 200, 1000);  //calculate value to be stored in "frequency" by taking the value of "mouseY" and map its value from a scale of "height" to 0, to a scale of 200 to 1000
  if(amplificationcontrol == true){               //
    amplitude = map(mouseX, 0, width, 0, 1);      //
  } else {                                        //the code: "} else if(amplificationcontrol == false){" is recommended for more possible cases and so more else if statements
    panning = map(mouseX,0 ,width, -1, 1);       
  } 
  tone.freq(frequency);
  tone.amp(amplitude);
  tone.pan(panning);
}

void mousePressed(){
  amplificationcontrol = !(amplificationcontrol);
}

void keyPressed(){
  if(key == ' ' && stop == false){
    //print("stopping");
    stop = true;
    noLoop();
    tone.amp(0);
  } else if (key == ' '){                       //the code : "} else if (keyCode == 32 && stop == true){" is recommended for more possible cases and so more else if statements
    //print("starting");
    stop = false;
    tone.amp(amplitude);
    loop();
  }
}
