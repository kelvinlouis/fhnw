> import Control.Monad
> import Control.Applicative hiding (Const, many)
> import Data.Char
> import Data.List
> import Test.HUnit

Übung 09: Rekursive Datentypen

In dieser Übung arbeiten Sie mit einfachen arithmetischen Ausdrücken.

Beispiele: "1+2*3" oder "(1+2)*(4+2)"

Ein Ausdruck kommt in den folgenden Formen:
- Konstante, z.B. 12       Repräsentation: Const 12
- Addition, e1 + e2        Repräsentation: Add e1 e2
- Multiplikation, e1 * e2  Repräsentation: Mul e1 e2
wobei e1 und e2 wieder arithmetische Ausdrücke sind.

> data Expr = Const Int
>           | Add Expr Expr
>           | Mul Expr Expr
>           deriving (Show, Eq)

Der Ausdruck "(1+2)*3" wird entsprechend so dargestellt:

> ex1 = Mul (Add (Const 1) (Const 2)) (Const 3)

Die Struktur wird deutlicher, wenn wir den Ausdruck mit infix Konstruktoren schreiben:

> ex2 = ((Const 1) `Add` (Const 2)) `Mul` (Const 3)

Denken Sie sich das `Add` als '+' und das `Mul` als '*'.

Den obigen Ausdruck können Sie sich auch als ein verkehrt herum stehenden Baum vorstellen.

       *
      / \
     +   3
    / \
   1   2

Eine solche Struktur nennt man Baum, weil sie mit einem einzelnen Element an der Wurzel
startet '*' und von da weitere Teile wie Äste davon abzweigen.

Aufgabe 1)
Zeichnen Sie den Baum und konstruieren Sie den Wert vom Typ Expr in Haskell für folgenden
Ausdruck: "(3*4)+(5+2)"
            +
          /   \
         /     \
        *       +
       / \     / \
      3   4   5   2

> exe1 = ((Const 3) `Mul` (Const 4)) `Add` ((Const 5) `Add` (Const 2)) 

Aufgabe 2)
Einen solchen arithmetischen Ausdruck kann man nun ausrechnen (evaluieren).
Implementieren Sie die Funktion eval. Als Argument nimmt sie einen arithmetischen Ausdruck
und berechnet dessen Wert.

Beispiel:
1 + 2 = 3
eval (Add (Const 1) (Const 2)) ~> 3

Hinweis:
Es handelt sich um eine rekursive Funktion. Überlegen Sie sich den Basisfall. Für welche
Expr ist der Wert sofort klar? Bei den anderen beiden Fällen, müssen Sie sich überlegen
wie man zum Resultat kommt, wenn die beiden Teilresultate schon evaluiert wurden:

> eval :: Expr -> Int
> eval (Const x) = x
> eval (Add a b) = (eval a) + (eval b)
> eval (Mul a b) = (eval a) * (eval b)

Aufgabe 3)
Schreiben Sie mindestens drei Unit Tests um die eval Funktion zu testen.

> evalSimpleAdd = eval ((Const 1) `Add` (Const 2))
> evalSimpleMul = eval ((Const 2) `Mul` (Const 6))
> evalMultipleLevels = eval (((Const 3) `Mul` ((Const 2) `Add` (Const 5))) `Add` ((Const 3) `Mul` ((Const 2) `Add` (Const 5))))

> tcEvalSimpleAdd = TestCase (assertEqual "1 +" 3 evalSimpleAdd)
> tcEvalSimpleMul = TestCase (assertEqual "2 * 6" 12 evalSimpleMul)
> tcEvalMultiLevels = TestCase (assertEqual "3*2 + 5 + 3 * (2 + 5) = 42" 42 evalMultipleLevels)
> main = runTestTT (TestList [tcEvalSimpleAdd, tcEvalSimpleMul, tcEvalMultiLevels])

Aufgabe 4)
Die Addition und die Multiplikation haben Eigenschaften, die es erlauben Ausdrücke
zu vereinfachen:

Wenn Sie eine Addition ausführen und die Konstante 0 auf einer Seite haben, können Sie die
Addition und die Konstante 0 entfernen, weil sie keinen Effekt haben:
0 + e == e + 0 == e

Beispiel:
Add (Const 0) (Const 1) kann vereinfacht werden nach (Const 1)

Überlegen Sie sich zwei weitere Vereinfachungsregelen für die Multiplikation.
Hinweis: Es geht um die Konstanten 0 und 1.

Implementieren Sie die Funktion simpl. Sie nimmt einen Ausdruck und gibt einen vereinfachten
Ausdruck zurück. Die Vereinfachung darf dabei den Wert des repräsentieren Ausdrucks nicht
verändern:
eval e == eval (simpl e)

> simpl :: Expr -> Expr
> simpl (Const a) = Const a
> simpl (Mul a (Const 0)) = Const 0
> simpl (Mul (Const 0) b) = Const 0
> simpl (Mul a (Const 1)) = simpl a
> simpl (Mul (Const 1) b) = simpl b
> simpl (Add a (Const 0)) = simpl a
> simpl (Add (Const 0) b) = simpl b
> simpl (Add a b) = Add (simpl a) (simpl b)
> simpl (Mul a b) = Mul (simpl a) (simpl b)

Aufgabe 5)
Schreiben Sie wiederum einige Unit Tests um die simpl Funktion zu überprüfen.

> addWith0 = simpl ((Const 0 `Add` (Const 1)))
> addWith0Nested = simpl ((Const 0) `Add` ((Const 0 `Add` (Const 1))))
> mulWith0 = simpl ((Const 0) `Mul` (Const 3))
> mulWith0Nested = simpl ((Const 2) `Mul` ((Const 0 `Mul` (Const 1))))
> mulWith1 = simpl ((Const 1) `Mul` (Const 6))
> mulWith1Nested = simpl ((Const 1) `Mul` ((Const 1 `Mul` (Const 4))))
> mulWithMixedNested = simpl ((Const 1) `Mul` ((Const 1 `Mul` (Const 0))))
> mixedAddMul = simpl ((Const 0) `Add` ((Const 1 `Mul` (Const 6))))

> tcAddWith0 = TestCase (assertEqual "0+1 = Const 1" (Const 1) addWith0)
> tcAddWithNested0 = TestCase (assertEqual "0 + (0 + 1) = Const 1" (Const 1) addWith0Nested)
> tcMulWith0 = TestCase (assertEqual "0 * 1 = Const 0" (Const 0) mulWith0)
> tcMulWithNested0 = TestCase (assertEqual "2 * (0 * 1) = Const 1" (Const 0) mulWith0Nested)
> tcMulWith1 = TestCase (assertEqual "1 * 6 = Const 6" (Const 6) mulWith1)
> tcMulWithNested1 = TestCase (assertEqual "1 * (1 * 4) = Const 4" (Const 4) mulWith1Nested)
> tcMulWithMixedNested = TestCase (assertEqual "1 * (1 * 0) = Const 0" (Const 0) mulWithMixedNested)
> tcMixedAddMul = TestCase (assertEqual "0 + (1 * 6) = Const 6" (Const 6) mixedAddMul)

> main2 = runTestTT (TestList [tcAddWith0, tcAddWithNested0, tcMulWith0, tcAddWithNested0, tcMulWith1, tcMulWithNested1, tcMulWithMixedNested, tcMixedAddMul])


== Zahltag ==
Weil Sie so fleissig waren und sich bis hier unten durchgearbeitet haben, haben wir
eine kleine Belohnung. Unten im File hat es einen Parser, der automatisch simple
arithmetische Ausdrücke in Expr Werte übersetzt.
> ex3 = parseExpr "(1+2)*3"  -- Mul (Add (Const 1) (Const 2)) (Const 3)

Sie haben nun selbst Funktionen geschrieben um solche Strukturen zu vereinfachen
und um sie zu evaluieren.
Das Ganze ist viel mehr als nur ein kleiner Taschenrechner. Es beinhaltet nämlich
die zentralen Elemente zur Implementierung einer interpretierten Programmiersprache:
Sourcecode -parsen-> Struktur -vereinfachen-> Struktur -ausführen-> Resultat

Wenn wir nun noch den Pipe Operator wie folgt zur Verfügung haben

> (|>) :: (a -> b) -> (b -> c) -> a -> c
> f |> g = g.f
Der Parser nimmt also einen String und erzeugt daraus eine Struktur vom Typ Expr.


können wir folgende, an Eleganz kaum zu übertreffende, Defintion hinschreiben:

> runExample = (parseExpr |> simpl |> eval) "(5+0)*8+2"

Hallelujah!




Der folgende Code implementiert generische Infrastruktur um Parser zu definieren.
Basieren darauf haben wir einen Parser für simple arithmetische Ausdrücke implementiert.

> data Parser a = Parser { run :: (String -> [(a, String)]) }
>
> parse p s = case find (\(_,r) -> null r) (run p s) of
>                  Nothing -> error "Illegal"
>                  Just (x,_) -> x
>
> item :: Parser Char
> item = Parser (\cs -> case cs of
>                     []     -> []
>                     (c:cs) -> [(c,cs)])
>
> instance Functor Parser where
>   fmap f p = Parser (\cs -> map (\(a,cs') -> (f a, cs')) (run p cs))
>
> instance Applicative Parser where
>   pure a = Parser (\cs -> [(a,cs)])
>   mf <*> ma = mf >>= \f -> ma >>= \a -> pure (f a)
>
> instance Monad Parser where
>   return = pure
>   p >>= f = Parser (\cs -> concat (map (\(a,cs') -> run (f a) cs') (run p cs)))
>
> instance Alternative Parser where
>    empty = Parser (\cs -> [])
>    p <|> q = Parser (\cs -> run p cs ++ run q cs)
>
>
> (+++) :: Parser a -> Parser a -> Parser a
> p +++ q = Parser (\cs -> case run (p <|> q) cs of
>                            [] -> []
>                            (x:xs) -> [x])
>
> sat :: (Char -> Bool) -> Parser Char
> sat p = do c <- item
>            if p c then return c else empty
>
> char :: Char -> Parser Char
> char c = sat (c ==)
>
> many :: Parser a -> Parser [a]
> many p = many1 p +++ return []
>
> many1 :: Parser a -> Parser [a]
> many1 p = do a <- p
>              as <- many p
>              return (a:as)
>

Semiformale Grammatik für simple arithmetische Ausdrücke:

expr ::= term
       | term + expr

term ::= factor
       | factor * term

factor ::= constant
         | '(' expr ')'

constant :: = (0..9)+


> parseExpr = parse expr
>
> expr  = do t <- term
>            char '+'
>            e <- expr
>            return (Add t e)
>         +++ term
>
> term  = do f <- factor
>            char '*'
>            t <- term
>            return (Mul f t)
>         +++ factor
>
> factor = constant
>          +++
>          do char '('
>             e <- expr
>             char ')'
>             return e
>
> constant = do ds <- many1 digit
>               let ints = map digitToInt ds
>               let val = foldl (\acc d -> acc * 10 + d) 0  ints
>               return (Const val)
>
> digit = sat isDigit
