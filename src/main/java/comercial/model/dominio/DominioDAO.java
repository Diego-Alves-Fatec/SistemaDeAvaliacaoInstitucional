package comercial.model.dominio;

public class DominioDAO {

    private DominioRepository dominioRepository;

    public Dominio consultaDominioValido(int cd_dominio) {
        return dominioRepository.findByCdDominio(cd_dominio);
    }
}
