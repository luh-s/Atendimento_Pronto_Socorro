public class Atendimento {
    private String idAtendimento;
    private Paciente paciente;
    private String medico;
    private String horarioEntrada;
    private String horarioAtendimento;
    private String status;


    public Atendimento(String idAtendimento, Paciente paciente, String medico, String horarioEntrada,
        String horarioAtendimento, String status) {
        this.idAtendimento = idAtendimento;
        this.paciente = paciente;
        this.medico = medico;
        this.horarioEntrada = horarioEntrada;
        this.horarioAtendimento = horarioAtendimento;
        this.status = status;
    }


    public String getIdAtendimento() {
        return idAtendimento;
    }


    public void setIdAtendimento(String idAtendimento) {
        this.idAtendimento = idAtendimento;
    }


    public Paciente getPaciente() {
        return paciente;
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }


    public String getMedico() {
        return medico;
    }


    public void setMedico(String medico) {
        this.medico = medico;
    }


    public String getHorarioEntrada() {
        return horarioEntrada;
    }


    public void setHorarioEntrada(String horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }


    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }


    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    

    
    
    

}
