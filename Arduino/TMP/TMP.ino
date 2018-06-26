const int sensorPin = A0;
const int baseTemp = 20;

void setup() {
  Serial.begin(9600);
  for(int pinNumber = 2; pinNumber < 4; pinNumber++){
    pinMode(pinNumber, OUTPUT);
    digitalWrite(pinNumber, LOW);
  }
}

void loop() {
  int sensorVal = analogRead(sensorPin);
  float voltage = (sensorVal/1024.0)*5.0;
  float temperature = (voltage - 0.5) * 100;
  
  Serial.print("Sensor value: ");
  Serial.print(sensorVal);
  Serial.print(", Volts: ");
  Serial.print(voltage);
  Serial.print(", degree C: ");
  Serial.println(temperature);

  if(temperature < baseTemp+2){
    digitalWrite(2, LOW);
    digitalWrite(3, LOW);
  }

  else if(temperature < baseTemp+4){
    digitalWrite(2, HIGH);
    digitalWrite(3, LOW);
  }

  else if(temperature >= baseTemp+4){
    digitalWrite(2, LOW);
    digitalWrite(3, HIGH);
  }
  
  delay(10);
}
