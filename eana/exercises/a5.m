% A.5 6)
syms x
f = 3*cos(2*x) + 1
p = -5.5*x^2 + 4

hold
ezplot(f)
ezplot(p)

%parabel_approx(-6,1,1);

function parabel_approx(a,b,c)
  f = @(x)(3*cos(2*x)+1);
  p = @(x)(a*x.^2+b*x+c);
  x = -pi:pi/200:pi;
  plot(x,f(x),'b');
  hold;
  plot(x,p(x),'r');
end