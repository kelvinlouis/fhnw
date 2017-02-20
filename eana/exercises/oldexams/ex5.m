clearvars;
syms x;

f = -(-12*x^5+24*x^4+21*x^3+33*x^2+33*x+9)/((2*x+1)^2);

a = limit(f,x,0)
b = limit(f,x,-0.5)
c1 = limit(f,x,Inf)
c2 = limit(f,x,-Inf)

hold on;
fplot(f, 'Color', 'Red');