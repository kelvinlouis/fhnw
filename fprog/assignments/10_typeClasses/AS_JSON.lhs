> {-# LANGUAGE FlexibleInstances, OverlappingInstances #-}

> import Data.List
> import Data.Char


Die JavaScript Object Notation, kurz JSON [ˈdʒeɪsən], ist ein kompaktes Datenformat 
in für Mensch und Maschine einfach lesbarer Textform zum Zweck des Datenaustauschs 
zwischen Anwendungen. [http://de.wikipedia.org/wiki/JavaScript_Object_Notation]

Hier ein Beispiel JSON Dokument:

{
    "firstName": "John",
    "lastName": "Smith",
    "age": 25,
    "address": {
        "streetAddress": "21 2nd Street",
        "city": "New York",
        "state": "NY",
        "postalCode": 10021
    },
    "phoneNumbers": [
        {
            "type": "home",
            "number": "212 555-1234"
        },
        {
            "type": "fax",
            "number": "646 555-4567"
        }
    ]
}


In dieser Übung programmieren eine kleine Library für den Umgang mit JSON.

JSON kennt sechs verschiedene Datentypen
Nullwert [JNull] : null
Boolean  [JBool] : true oder false
Zahl     [JNum]  : Eine Gleitkommazahl Bsp. 12, 3.41
String   [JStr]  : Ein folge von Zeichen zwischen Anführungs- und Schlusszeichen.
Sequenz  [JSeq]  : Eine geordnete Sequenz (Liste) von JSON Werten, Komma-separiert.
Object   [JObj]  : Eine ungeordnete Menge von Schlüssel-Werte-Paaren, Komma-separiert. 
                   Die Schlüssel sind Strings und die Werte sind JSON Werte. 


1. Aufgabe
Definieren Sie den Datentyp JSON um JSON Daten abzubilden.
Hinweise: 
- Verwenden Sie die Namen in den eckigen Klammern als Wertkonstruktor Namen.
- Alle Wertkonstruktoren haben genau eine Komponente ausser JNull hat keine.
- Verwenden Sie Double für die Komponente von JNum.
- Verwenden Sie Sie ein Liste von Paaren für die Komponente von JObj.
- Falls Sie nicht weiter kommen, finden Sie ganz unten eine verschlüsselte Lösung damit Sie 
  die folgenden Aufgaben trotzdem lösen können.

> data JSON = JBool Bool
>           | JNum Double
>           | JStr String
>           | JSeq [JSON]
>           | JObj [(String, JSON)]
>           | JNull
>           deriving (Show, Eq)


2. Aufgabe
Definieren Sie die Funktion showJ, die JSON Daten in einen hübsch formatierten
String übersetzt:

> showJ :: JSON -> String
> showJ (JBool b) = map toLower (show b)
> showJ (JNum n) = show n
> showJ (JStr s) = concat ["\"", s, "\""]
> showJ (JNull) = "null"
> showJ (JSeq list) = "[" ++ recur list ++ "]"
>                     where recur [x] = showJ x
>                           recur (x:xs) = showJ x ++ ", " ++ recur xs
> showJ (JObj pairs) = "{" ++ recur pairs ++ "}"
>                      where recur [p] = pair p
>                            recur (p:xs) = concat [pair p, ", ", recur xs]
>                            pair (key, val) = concat ["\"", key, "\"", ": ", showJ val]

3. Aufgabe
Definieren Sie die Typklasse ToJSON. Sie soll eine Methode toJSON haben, die 
ein Wert nimmt und diesen in ein JSON Wert übersetzt:

> class ToJSON a where
>   toJSON :: a -> JSON

4. Aufgabe
Implementieren Sie Instanzen für String, Bool, Double, Int und Integer:
Hinweis: Integer und Int können Sie mit der Funktion fromIntegral in ein Double übersezten

> instance ToJSON String where
>   toJSON s = JStr s
> instance ToJSON Bool where
>   toJSON b = JBool b
> instance ToJSON Int where
>   toJSON i = JNum (fromIntegral i :: Double)
> instance ToJSON Integer where
>   toJSON i = JNum (fromIntegral i :: Double)
> instance ToJSON Double where
>   toJSON d = JNum d

5. Aufgabe
Implementieren Sie eine Instanz für Listen deren Elemente einen Typ haben
der zur Klasse ToJSON gehört. Als Resultat soll eine JSeq rauskommen.

> instance (ToJSON a) => ToJSON [a] where
>   toJSON xs = JSeq (map toJSON xs)

6. Aufgabe
Gegeben ist der Type Student. Implementieren Sie eine ToJSON Instanz 
für diesen Typ.

> data Student = Student {  email :: String,
>                           matrikelNr :: Int
>                        } deriving Show

> instance ToJSON Student where
>   toJSON (Student email matrikelNr) = JObj [("email", toJSON email), ("matrikelNr", toJSON matrikelNr)]

Wenn Sie alles richtig gemacht haben, können Sie jetzt eine Liste von Studenten
nach JSON übersetzen und hübsch als String serialisieren:

> students = [Student "fred.feuerstein@students.fhnw.ch" 1, Student "wilma.feuerstein@students.fhnw.ch" 2]

Aktivieren Sie folgende Zeile wenn Sie alle notwendigen Funktionen definiert haben und führen Sie die
Funktion main aus:

> main = (putStr.showJ.toJSON) students



-----------------------  TOP SECRET -------------------------

Falls Sie den Datentyp nicht definieren konnten, ist hier die Lösung (rot13.com):

 qngn WFBA = WFrd [WFBA]
           | WBow [WOvaqvat] 
           | WAhz Qbhoyr
           | WFge Fgevat
           | WObby Obby
           | WAhyy
           qrevivat (Fubj, Rd)

 glcr WOvaqvat = (Fgevat,WFBA)

