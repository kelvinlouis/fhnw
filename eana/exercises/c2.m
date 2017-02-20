syms x;

f  = (x^5 + 2*x^4 + x^3 + 2*x^2);
f1 = (5*x^4 + 8*x^3 + 3*x^2 + 4*x);
f2 = (20*x^3 + 24*x^2 + 6*x + 4);
f3 = (60*x^2 + 48*x + 6);
f4 = (120*x + 48);
f5 = (120 + x * 0);

%hold on
%ezplot(f);
%ezplot(f1);
%ezplot(f2);
%ezplot(f3);
%ezplot(f4);
%ezplot(f5);

g1 = (x^3 + 1);
g1i = (12*x-15);
g2 = (x^2 + 8*x + 16);
g2i = (12*x+12);
g1j = ((48/9) * (x + (4/3)) - (37/27));
g2j = ((16/3) * (x + (4/3)) + (64/9) );

hold on
%ezplot(g1);
%ezplot(g2);
%ezplot(g1i);
%ezplot(g2i);
%ezplot(g1j);
%ezplot(g2j);


k1 = (x^(-2));
ki = (-2*x^(-3));
kt = ((1/4)*x+(3/4));
kt_ = ((-4)*x+(3/4));

ezplot(k1);
ezplot(kt);
ezplot(kt_);