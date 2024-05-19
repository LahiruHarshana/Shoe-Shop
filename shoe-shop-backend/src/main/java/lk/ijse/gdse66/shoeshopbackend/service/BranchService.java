package lk.ijse.gdse66.shoeshopbackend.service;


import lk.ijse.gdse66.shoeshopbackend.dto.BranchDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.Branch;

import java.util.List;

/**
 * @author : L.H.J
 * @File: BranchService
 * @mailto : lharshana2002@gmail.com
 * @created : 2024-05-12, Sunday
 **/
public interface BranchService {
    boolean saveBranch(BranchDTO branchDTO);

    List<BranchDTO> getAllBranches();

    boolean updateBranch(BranchDTO branchDTO);

    boolean deleteBranch(String branchId);

    List<String> getBranchIds();

    Branch getBranchById(String branchId);
}
