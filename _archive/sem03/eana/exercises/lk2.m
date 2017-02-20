syms t

% 3
f1 = @(x)(2*sin(3*x+ (pi/2)));
f2 = @(x)(2*cos(3*x));

% 4
f3 = @(x)(sin(x)^2);

% Plot with coordinates
hold
ax = gca;
ax.XAxisLocation = 'origin';
ax.YAxisLocation = 'origin';
xticks([-3*pi -2*pi -pi 0 pi 2*pi 3*pi]);
xticklabels({'-3\pi','-2\pi','-\pi','0','\pi','2\pi','3\pi'});

%ezplot(f1(t))
%ezplot(f2(t))
ezplot(f3(t));