package ru.itlab.tenderhackbe.repositories;

import org.apache.xmlbeans.impl.jam.JamServiceParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itlab.tenderhackbe.models.SellerInfo;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
}
