package javaCore.colectionDemo.enumColectionDemo.enumAndInterface;

public enum RectangleParam implements ShapeService {
    PERIMETER {
        @Override
        public double service(double... param) {
            return 2 * (param[0] + param[1]);
        }
    },
    SQUARE {
        @Override
        public double service(double... param) {
            return param[0] * param[1];
        }
    }
}
