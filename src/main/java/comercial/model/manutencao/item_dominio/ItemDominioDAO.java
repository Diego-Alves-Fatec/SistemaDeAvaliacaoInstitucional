package comercial.model.manutencao.item_dominio;

import comercial.model.dominio.Dominio;
import comercial.model.dominio.DominioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDominioDAO {

    @Autowired
    ItemDominioRepository itemDominioRepository;

    @Autowired
    DominioDAO dominioDAO;


    public List<ItemDominio> carregarItemDominioPorCd(Dominio dominio) {

        return itemDominioRepository.findItemDominioByFkCdDominio(dominio);
    }
}
