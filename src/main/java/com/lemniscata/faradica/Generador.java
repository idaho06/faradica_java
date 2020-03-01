package com.lemniscata.faradica;

public class Generador {

    private Forma onda = Forma.SINDEFINIR;
    private Float t_pulso = 0.0f;
    private Float t_reposo = 0.0f;
    private Polaridad polaridad = Polaridad.SINDEFINIR;
    private Float t_tren = 0.0f;
    private float t_rampaSubida = 0.0f;
    private float t_rampaBajada = 0.0f;
    private float t_pausa = 0.0f;
    private Modo modo = Modo.SINDEFINIR;
    private float frecuencia = 0.0f;

    public Generador() {
        this.onda = Forma.CUADRADA;
        this.t_pulso = 0.1f;
        this.t_reposo = 10.0f;
        this.polaridad = Polaridad.MONOFASICA;
        this.t_tren = 10.0f;
        this.t_rampaSubida = 0.0f;
        this.t_rampaBajada = 0.0f;
        this.t_pausa = 1.0f;
        this.modo = Modo.CANAL_A;
        tick(); // hacemos un primer cálculo
    }

    public void tick() {
        // Recalcula todos los valores que correspondan

        if (this.t_pulso < 0.1f) {
            this.t_pulso = 0.1f;
        }
        if (this.t_pulso > 10.0f) {
            this.t_pulso = 10.0f;
        }

        if (this.t_reposo < 10.0f) {
            this.t_reposo = 10.0f;
        }
        if (this.t_reposo > 100.0f) {
            this.t_reposo = 100.0f;
        }

        if (this.t_tren < 1.0f) {
            this.t_tren = 1.0f;
        }
        if (this.t_tren > 30.0f) {
            this.t_tren = 30.0f;
        }

        float t_limiteRampa = t_tren / 2.0f;
        if (this.t_rampaSubida < 0.0f) {
            this.t_rampaSubida = 0.0f;
        }
        if (this.t_rampaSubida > t_limiteRampa) {
            this.t_rampaSubida = t_limiteRampa;
        }

        if (this.t_rampaBajada < 0.0f) {
            this.t_rampaBajada = 0.0f;
        }
        if (this.t_rampaBajada > t_limiteRampa) {
            this.t_rampaBajada = t_limiteRampa;
        }

        if (this.t_pausa < 0.0f) {
            this.t_pausa = 0.0f;
        }
        if (this.t_pausa > 60.0f) {
            this.t_pausa = 60.0f;
        }

        this.frecuencia = 1000.0f / (this.t_pulso + this.t_reposo);
    }

    public Forma getOnda() {
        return onda;
    }

    public void setOnda(Forma onda) {
        this.onda = onda;
        //this.tick();
    }

    public float getFrecuencia() {
        return frecuencia;
    }
}
