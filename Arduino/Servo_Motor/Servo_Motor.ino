#include <Servo.h>
Servo myServo;

int potPin = A0;
int potVal;
int angle = 0;
int angleChange = 1;
int changeAmount;

void setup() {
  myServo.attach(9);
  Serial.begin(9600);
  
}

void loop() {
  potVal = analogRead(potPin);
  
  changeAmount = (potVal / 1023.0) * 180;
  
  if(angleChange > 0){
    if(angle < 179){
      angle = angle + changeAmount;
    } else {
      angleChange = -1;
    }
  }else if(angleChange < 0){
      if(angle > 0){
        angle = angle - changeAmount;
      } else {
        angleChange = 1;
      }
   }
    
  
  
  Serial.println(changeAmount);
  myServo.write(angle);
  delay(50);
}
