syms x;

f = (x^3+x+1)/((x^2+1)^2);
d = @(x)sqrt((x-4)^2+(f(x)-1)^2);
%di = diff(d);

%hold
%ezplot(f)