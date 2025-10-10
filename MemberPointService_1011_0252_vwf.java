// 代码生成时间: 2025-10-11 02:52:19
 * MemberPointService.java
 *
 * 会员积分系统服务组件
 */

package com.example.service;

import com.example.repository.MemberPointRepository;
import com.example.exception.MemberPointException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberPointService {

    @Autowired
    private MemberPointRepository memberPointRepository;

    /**<ol>
     * 根据会员ID增加积分
     *
     * @param memberId 会员ID
     * @param points   增加的积分数
     * @return        增加积分后的会员积分
     * @throws MemberPointException 如果会员ID不存在，则抛出异常
     * @throws ResponseStatusException 如果操作失败，则抛出异常
     */
    @Transactional
    public int addPoints(int memberId, int points) {
        if (points < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "积分数不能为负");
        }

        return memberPointRepository.addPoints(memberId, points);
    }

    /**<ol>
     * 获取会员积分
     *
     * @param memberId 会员ID
     * @return         会员积分
     * @throws MemberPointException 如果会员ID不存在，则抛出异常
     */
    public int getPoints(int memberId) {
        int points = memberPointRepository.getPoints(memberId);
        if (points == 0) {
            throw new MemberPointException("会员ID不存在");
        }
        return points;
    }
}
