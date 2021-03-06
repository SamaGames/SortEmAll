package com.github.keyzou.villagerrun.entities.ai;

import com.github.keyzou.villagerrun.entities.PNJ;
import net.minecraft.server.v1_9_R1.PathfinderGoal;
import org.bukkit.Location;

/*
 * This file is part of PersistanceAPI.
 *
 * PersistanceAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PersistanceAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PersistanceAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PathfinderGoalWalk extends PathfinderGoal {
    /**
     * PNJ's destination
     */
    private Location objective;
    /**
     * Le famous PNJ
     */
    private PNJ pnj;

    public PathfinderGoalWalk(PNJ pnj, Location objective){
        this.pnj = pnj;
        this.objective = objective;
    }

    /**
     * Method shouldExecute()
     * @return Always true so the PNJ will always go to its destination
     */
    @Override
    public boolean a() {
        return true;
    }

    /**
     * Method startExecuting(), we make the PNJ go to his destination
     */
    @Override
    public void c(){
        this.pnj.getNavigation().a(objective.getBlockX()+0.5, objective.getBlockY(), objective.getBlockZ()+0.5, 0.5f );
    }

    /**
     * Nothing should stop this PNJ
     * @return false
     */
    @Override
    public boolean b() {
        return false;
    }

    /**
     * When we update his path, we lock his Y and Z motion so he can follow only an one-axis path
     */
    @Override
    public void e(){
        pnj.addLife(1);
        pnj.motZ = 0;
        pnj.motY = 0;
    }


}
