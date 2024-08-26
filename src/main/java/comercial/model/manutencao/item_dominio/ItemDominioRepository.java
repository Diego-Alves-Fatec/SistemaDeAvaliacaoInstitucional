package comercial.model.manutencao.item_dominio;

import comercial.model.dominio.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemDominioRepository extends JpaRepository<ItemDominio, Integer> {
    List<ItemDominio> findItemDominiosByFkCdDominio(Dominio fkCdDominio);

}
