package com.nighthawk.spring_portfolio.mvc.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {
  Player save(Player player);
}
