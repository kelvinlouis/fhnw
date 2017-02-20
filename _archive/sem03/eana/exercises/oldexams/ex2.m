clearvars;
syms x;

% Minimalabstand zwischen zwei Punkten auf verschiedenen Funktionen
% Punkt auf g ist um x+1 verschoben

f = 3+(x^3-2)*(x-1)*(x+3);
g = -4-(x^2-1)*(x-2)*(x+4);

d = sqrt((x-(x+1))^2+(f-subs(g,x,(x+1)))^2); % Abstandsfunktion
d1 = diff(d);
d2 = diff(d,2);
ex = double(solve(d1,x)); % Extrempunkte erhalten

% Nur reele Werte berücksichtigen
% Ueberpruefe d''(x) > 0 = Minimal
subs(d2,x,ex(1)) 
subs(d2,x,ex(8))
subs(d2,x,ex(9))

hold on;
ezplot(g)
ezplot(f)

% Minimal Abstand 1
plot(ex(1),subs(f,x,ex(1)),'r.','MarkerSize',10);   
plot(ex(1)+1,subs(g,x,ex(1)+1),'r.','MarkerSize',10);  

% Minimal Abstand 2
plot(ex(9),subs(f,x,ex(9)),'r.','MarkerSize',10);   
plot(ex(9)+1,subs(g,x,ex(9)+1),'r.','MarkerSize',10); 

% Aufgabe b
% Wann gehen die Teilchen in diesselbe Richtung?
% Steigung der beiden Funktionen gleichsetzen
mt = diff(f) - diff(g);
fzero(inline(mt),-2)
fzero(inline(mt),2)

%ezplot(subs(diff(f),x,1.2868) * (x-1.2868) + subs(f,x,1.2868))
%ezplot(subs(diff(g),x,1.2868) * (x-1.2868) + subs(g,x,1.2868))