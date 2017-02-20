syms x

fn = 2/(x+1)-1;
x1 = 0 - (subs(fn,x,0)/subs(diff(fn),x,0));
x2 = (1/2) - (subs(fn,x,(1/2))/subs(diff(fn),x,(1/2)));
x3 = (7/8) - (subs(fn,x,(7/8))/subs(diff(fn),x,(7/8)));

f4 = x*(x+2)*(x-1);
f4int = [-2 1];
area = int(f4,0,-2) - int(f4,0,1);


% monoton fallend...muss man links beginnen
f3b = (x/(1+exp(x)));
f4 = (1/2)*exp(2*x+1)+1;

