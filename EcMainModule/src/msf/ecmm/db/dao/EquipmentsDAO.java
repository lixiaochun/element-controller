/*
 * Copyright(c) 2017 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.db.dao;

import static msf.ecmm.db.DBAccessException.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import msf.ecmm.db.DBAccessException;
import msf.ecmm.db.pojo.Equipments;

/**
 * Model Information DAO Class.
 */
public class EquipmentsDAO extends BaseDAO {

  /**
   * Model Information Class Constructor.
   *
   * @param session
   *          data base session
   */
  public EquipmentsDAO(Session session) {
    this.session = session;
  }

  /**
   * Model Information Table INSERT.
   *
   * @param equipments
   *          model information to be registered
   * @throws DBAccessException
   *           data base exception
   */
  public void save(Equipments equipments) throws DBAccessException {
    try {
      Equipments regequipments = session.get(Equipments.class, equipments.getEquipment_type_id());
      if (regequipments != null) {
        this.errorMessage(DOUBLE_REGISTRATION, EQUIPMENTS, null);
      } else {
        session.save(equipments);
      }
    } catch (DBAccessException e1) {
      throw e1;
    } catch (Throwable e2) {
      logger.debug("equipments insert failed.", e2);
      this.errorMessage(INSERT_FAILURE, EQUIPMENTS, e2);
    }
  }

  /**
   * Model Information Table DELETE.
   *
   * @param equipment_type_id
   *          model ID (primary key)
   * @throws DBAccessException
   *           data base exception
   */
  public void delete(String equipment_type_id) throws DBAccessException {
    try {
      Equipments equipments = session.get(Equipments.class, equipment_type_id);
      if (equipments == null) {
        this.errorMessage(NO_DELETE_TARGET, EQUIPMENTS, null);
      } else {
        Query query = session.getNamedQuery("deleteEquipments");
        query.setString("key1", equipment_type_id);
        query.executeUpdate();
      }
    } catch (DBAccessException e1) {
      throw e1;
    } catch (Throwable e2) {
      logger.debug("equipments delete failed.", e2);
      this.errorMessage(DELETE_FAILURE, EQUIPMENTS, e2);
    }
  }

  /**
   * Model Information Table All SELECT.
   *
   * @return model information list
   * @throws DBAccessException
   *           data base exception
   */
  @SuppressWarnings("unchecked")
  public List<Equipments> getList() throws DBAccessException {
    List<Equipments> list = null;
    try {
      Query query = session.getNamedQuery("selectEquipmentsAll");
      list = query.list();
      for (Equipments equipments : list) {
        equipments.setEquipment_type_id(equipments.getEquipment_type_id());
      }
    } catch (Throwable e1) {
      logger.debug("equipments all select failed.", e1);
      this.errorMessage(SERCH_FAILURE, EQUIPMENTS, e1);
    }
    return list;
  }

  /**
   * Model Information Table SELECT.
   *
   * @param equipment_type_id
   *          model ID (primary key)
   * @return model information
   * @throws DBAccessException
   *           data base exception
   */
  @SuppressWarnings("unchecked")
  public Equipments search(String equipment_type_id) throws DBAccessException {
    Equipments equipments = null;
    try {
      Query query = session.getNamedQuery("selectEquipments");
      query.setString("key1", equipment_type_id);
      List<Equipments> equipmentsList = query.list();
      if (!equipmentsList.isEmpty() && equipmentsList.size() == 1) {
        equipments = equipmentsList.get(0);

      }
    } catch (Throwable e1) {
      logger.debug("equipments select failed.", e1);
      this.errorMessage(SERCH_FAILURE, EQUIPMENTS, e1);
    }
    return equipments;
  }

}
