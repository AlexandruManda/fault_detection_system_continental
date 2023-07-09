
/* UART SERIAL DEFINES */

String num1 = "ModuleName";
String num2 = "ModuleID";
String num3 = "ResistorID";
String num4 = "QtyResistor";
String num5 = "CapacitorID";
String num6 = "QtyCapacitor";


void setup()
{
  Serial.begin(9600); // baud rate = cati biti pe secunda se transmit

  //dezactivare receptor(RX) si activare emitor(TX)
  UCSR0B = (0 << RXEN0) | (1 << TXEN0);

  //setare format: 8data, 1 biti de stop
  UCSR0C = (0 << USBS0) | (1 << UCSZ01) | (1 << UCSZ00);

}

//Functia de transmitere seriala
void USART_Transmit(unsigned char data)
{
  //primeste ca tip de data un caracter si asteapta ca UDRE0 sa fie 1
  //cand UDRE0 este 1, UDR0(regsitrul de date) este gol(adica 00000000) si pot sa scriu in el
  while ((UCSR0A & (1 << UDRE0)) == 0)
  {
  }
  UDR0 = data;
}

//Functia pentru transmiterea unui sir de caractere pe seriala
void SendString(String stringToSend)
{
  for (int i = 0; i < stringToSend.length(); i++)
  {
    USART_Transmit(stringToSend[i]);
  }
}


void loop()
{
  SendString(num1 + ": ABS" + "-");
  SendString(num2 + ": PN02945" + "-");
  SendString(num3 + ": MAT2123" + "-");
  SendString(num4 + ": 21" + "-");
  SendString(num5 + ": MAE1245" + "-");
  SendString(num6 + ": 30" + "!");

  delay(1000);

  SendString(num1 + ": ECU" + "-");
  SendString(num2 + ": PN02912" + "-");
  SendString(num3 + ": MAT2123" + "-");
  SendString(num4 + ": 15" + "-");
  SendString(num5 + ": MAE1245" + "-");
  SendString(num6 + ": 20" + "!");
  

  delay(1000);
}
