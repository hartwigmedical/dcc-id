/*
 * Copyright 2013(c) The Ontario Institute for Cancer Research. All rights reserved.
 * 
 * This program and the accompanying materials are made available under the terms of the GNU Public
 * License v3.0. You should have received a copy of the GNU General Public License along with this
 * program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.icgc.dcc.id.server.repository;

import org.icgc.dcc.id.core.Prefixes;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public abstract class DonorRepository extends BaseRepository {

  public String findId(boolean create, String submittedDonorId, String submittedProjectId, String release) {
    return super.findId(create, submittedDonorId, submittedProjectId, release);
  }

  /**
   * Template method extension point.
   */
  @Override
  Long getId(String... keys) {
    return getDonorId(
        keys[0] /* donorId */,
        keys[1] /* projectId */);
  }

  /**
   * Template method extension point.
   */
  @Override
  Long insertId(String... keys) {
    return insertDonorId(
        keys[0] /* donorId */,
        keys[1] /* projectId */,
        keys[2] /* creationRelease */);
  }

  /**
   * Template method extension point.
   */
  @Override
  String getPrefix() {
    return Prefixes.DONOR_ID_PREFIX;
  }

  /**
   * JDBI instrumented.
   */
  @SqlQuery("sql/donor-id-select")
  abstract Long getDonorId(
      @Bind("donorId") String donorId,

      @Bind("projectId") String projectId);

  /**
   * JDBI instrumented.
   */
  @SqlUpdate("sql/donor-id-insert")
  @GetGeneratedKeys
  abstract Long insertDonorId(
      @Bind("donorId") String donorId,

      @Bind("projectId") String projectId,

      @Bind("creationRelease") String creationRelease);

}
