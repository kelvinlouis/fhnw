syms x;

% Exercise 46
f46 = sqrt(x^2+5);
f46d1 = diff(f46);
f46d2 = diff(f46,2);
delta46 = subs(f46,x,(2+x)) - subs(taylor(f46,'order',2,'expansionPoint',2),x,(2+x)) < 0.1;
delta46m = (5/9)*x^2+(4/30)*x-(61/100);
delta46m2 = sqrt((2+x)^2+5)-3+(2/3)*x < 0.1;