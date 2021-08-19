package models;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public double percentualReajuste() {
            return 0.03;
        }
    },
    BOM {
        @Override
        public double percentualReajuste() {
            return 0.15;
        }
    },
    OTIMO {
        @Override
        public double percentualReajuste() {
            return 0.20;
        }
    };

    public abstract double percentualReajuste();
}
