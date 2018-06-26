int notes[] = {196.00, 174.61, 155.56, 146.83};

void setup() {
  Serial.begin(9600);

}

void loop() {
  int keyVal = analogRead(A0);
  Serial.println(keyVal);
  


  if(keyVal >= 1010){
    tone(8, notes[0]);
  } else if(keyVal >= 990) {
    tone(8, notes[1]);
  } else if(keyVal >= 505) {
    tone(8, notes[2]);
  } else if(keyVal >= 5){
    tone(8, notes[3]);
  } else {
    noTone(8);
  }
}

