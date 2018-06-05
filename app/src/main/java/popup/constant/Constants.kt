package popup.constant

import popup.bean.M_Data
import java.util.*

class Constants {



    companion object {
        private val beanMap = HashMap<String, M_Data>()
        //选择项
        fun setBeanMap(key: String, data: M_Data) {
            if (beanMap.containsKey(key)) {
                beanMap.set(key,data)
            } else {
                beanMap.put(key,data)
            }
        }

        fun getIdByKey(key: String): Int {
          return if (beanMap.containsKey(key)) beanMap[key]!!.id else -1

        }
    }



}