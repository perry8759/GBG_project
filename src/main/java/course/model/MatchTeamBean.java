//model
package course.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ACT.model.ACT;
import member.model.MemberBean;

@Entity
@Table(name="match_team")
public class MatchTeamBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer match_team_id;
	private String team_name;
	private String team_unit;
	
	//雙向多對一，多個報名隊伍會報名同一個活動
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACT_ID")
	private ACT act_id;
	
	//單向多對一，此報名隊伍為何種報名狀態
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reg_status_id")
	private RegStatusBean reg_status_id;
	
	//雙向一對多 (此報名隊伍在各單局之分數)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "match_team_id")
	List<MatchPairBean> scores=new LinkedList<>();

	@ManyToMany(cascade = CascadeType.ALL) // 雙向多對多 (參與此隊伍的多個會員)
	@JoinTable(	name = "mem_team",  //中介表格為 mem_team
				joinColumns = { @JoinColumn(name="match_team_id",referencedColumnName = "match_team_id") }, 
				inverseJoinColumns = { @JoinColumn(name="member_id",referencedColumnName = "member_id") })
	private Set<MemberBean> members=new LinkedHashSet<>();

	public MatchTeamBean() {
		super();
	}

	public MatchTeamBean(String team_name, String team_unit, ACT act_id, RegStatusBean regs_status_id) {
		super();
		this.team_name = team_name;
		this.team_unit = team_unit;
		this.act_id = act_id;
		this.reg_status_id = regs_status_id;
	}

	public Integer getMatch_team_id() {
		return match_team_id;
	}

	public void setMatch_team_id(Integer match_team_id) {
		this.match_team_id = match_team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_unit() {
		return team_unit;
	}

	public void setTeam_unit(String team_unit) {
		this.team_unit = team_unit;
	}

	public ACT getAct_id() {
		return act_id;
	}

	public void setAct_id(ACT act_id) {
		this.act_id = act_id;
	}

	public RegStatusBean getReg_status_id() {
		return reg_status_id;
	}

	public void setReg_status_id(RegStatusBean reg_status_id) {
		this.reg_status_id = reg_status_id;
	}

	public Set<MemberBean> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberBean> members) {
		this.members = members;
	}

	public List<MatchPairBean> getScores() {
		return scores;
	}

	public void setScores(List<MatchPairBean> scores) {
		this.scores = scores;
	}
	
	
}
