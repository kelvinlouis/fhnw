syms x

f2 = x/(sqrt(1+x^2));
f2d = diff(f2);
f2d2 = diff(f2,2);
f2t = taylor(f2, 'order', 2+1, 'expansionPoint', 1);

p1 = subs(f2,x,1)+subs(diff(f2),x,1)*(x-1);
p2 = p1 + (1/2) * subs(diff(f2,2),x,1)*(x-1)^2;

f2int = @(x) (x/(x^2 + 1)^(1/2) - 2^(1/2)/2 - (2^(1/2)*(x - 1))/4 + (3*2^(1/2)*(x - 1)^2)/16);

hold
g2 = ezplot(f2)
g2t = ezplot(f2t)

fzero(@(x)f2int(x)-0.1,0)
fzero(@(x)f2int(x)-0.1,2)

% Ex 5
f5 = 1/(1+x);
f5d1 = diff(f5,1);